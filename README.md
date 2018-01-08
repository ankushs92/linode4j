# linode4j #

![travis!](https://travis-ci.org/ankushs92/linode4j.svg?branch=master "travis")

linode4j is a Java library for [Linode's V4 REST API](https://developers.linode.com/v4). 
 
# Links

Maven : 

```xml
<dependency>
  <groupId>in.ankushs</groupId>
  <artifactId>linode4j</artifactId>
  <version>1.2</version>
</dependency>
```

Gradle :
```groovy
compile('in.ankushs:linode4j:1.2')
```


# Node #
Linode's own V4 API is currently in beta. I will try my very best to keep linode4j up to date. Still, I would suggest you work with Linode's V3 for the time being, till the time V4 is promoted to alpha or production ready.

# Get Token #

You need an [OAuth](https://developers.linode.com/v4/access) token to use Linode's API.
To get the token, do the following steps :

1. [Login](https://cloud.linode.com/linodes) to linode
2. Click on your profile icon on the top right
3. Go to 'My Profile'
4. Click on 'Api Tokens'
5. Click the button 'Create a Personal Access Token'


# Get Started #

Create an instance of `LinodeApiClient` : 

```java
final String oauthToken = "YOUR_TOKEN";
//Connect with Linode
final LinodeApiClient api = new LinodeApiClient(oauthToken);    
```

Linode4j uses OkHttp3 underneath. You can pass your instance of `OkHttpClient` if you so wish:

```java
       
final String oauthToken = "YOUR_TOKEN";
final OkHttpClient okHttpClient =  new OkHttpClient()
                                        .newBuilder()
                                              .readTimeout(5, TimeUnit.SECONDS)
                                              .connectionPool(new ConnectionPool(5,5,TimeUnit.MINUTES))
                                        .build();
final LinodeApiClient api = new LinodeApiClient(oauthToken,okHttpClient);

```

**Note** 

Refer to the [Pagination](https://developers.linode.com/v4/pagination) guide to understand how linode implements pagination. A GET request for a collection of objects(for example, a collection of linodes registered with your account) returns the collection along with paging parameters.
The default page size is 25. When requesting for collection of objects, it is mandatory to pass in a `pageNo`.
To view the first 25 collections, therefore, set pageNo = 1 
 
For example, here is how you get a paginated list of linodes created by your account:

```java
final int pageNo = 1;
//Get Linodes along with paging parameters
final Page<Linode> pagedLinodes = api.getLinodes(pageNo);

//If there are 10 pages, this param signifies the current page we are on
final int currentPageCount = pagedLinodes.getCurrentPageCount();

//The total number of pages. If totalResults = 250, and the default value of objects returned by Linode is 25, then totalPages = (250/25) = 10
final int totalPages = pagedLinodes.getTotalPages();

//Total number of linodes registered with your account
final int totalResults = pagedLinodes.getTotalResults();

final Set<Linode> linodes = pagedLinodes.getContent();

//Discover linode properties
for(final Linode linode : linodes){
    final int id = linode.getId();

    //When was the linode created?
    final LocalDateTime createdOn = linode.getCreatedOn();

    //The alerts set on this linode
    final Alert alerts = linode.getAlerts();

    final Set<String> publicIps = linode.getIpv4Addresses();
    final String linodeIpv6 = linode.getIpv6Address();
    
    final HyperVisor hyperVisor = linode.getHyperVisor();
    if(hyperVisor == HyperVisor.KVM) {
        // DO SOMETHING
    }
    
    final LinodeStatus status = linode.getStatus();
    switch(status){
        case SHUTTING_DOWN : // do stuff
        case OFFLINE : //do something
        case MIGRATING : //your linode is migrating, don't panic!
        // etc
    }
}
//Kernel info
final Page<Kernel> pagedKernels = api.getKernels(pageNo);
final Set<Kernel> kernels = pagedKernels.getContent();

for(final Kernel kernel : kernels){
    final Architecture architecture = kernel.getArchitecture();
    if(architecture == Architecture.X86_64){
        //64 bit distribution
    }
    final boolean isSuitableForKvm = kernel.getIsSuitableForKvm();
    final boolean isSuitableForXen = kernel.getIsSuitableForXen();
    //Other fields
}

```

To create a Linode, you must provide the api with `region` and `linodeType` . Let's query Linode for  regions and types available to us.

```java
final Page<Region> pagedRegions = api.getRegions(pageNo);
final Set<Region> regions = pagedRegions.getContent();

for(final Region region : regions){
    //id : us-southeast-1a, ap-south-1a etc
    final String id = region.getId();

    //country : us, sg etc
    final String country = region.getCountry();
}

final Page<LinodeType> pagedLinodeTypes = api.getLinodeTypes(pageNo);
final Set<LinodeType> types = pagedLinodeTypes.getContent();
for(final LinodeType type : types){
    //For example : g5-standard-4, g5-nanode-1, g5-highmem-8 etc
    final String id = type.getId();

    final Plan plan = type.getPlan();
    switch(plan){
        case NANODE : //the smallest linode
        case STANDARD : //standard linodes
        case HIGH_MEMORY : // the new series of high memory linodes
    }
    
    final Integer outboundBandwidth = type.getOutboundBandwidth();
    //and other properties, you get the idea
}
```

Onward to creating and deleting our linode. To create **any** object from linode4j, you'll need to use the [Builder Design Pattern](https://www.google.co.in/search?q=Builder+design+pattern&oq=Builder+design+pattern+&aqs=chrome..69i57j69i60l3.3686j0j9&sourceid=chrome&ie=UTF-8)
```java
 final String usSouthwest = "us-southeast-1a";
 final String nanodeType = "g5-nanode-1";
 final LinodeCreateRequest createRequest = LinodeCreateRequest
         .builder()
             .region(usSouthwest) //REQUIRED
             .type(nanodeType) //REQUIRED
             .backupsEnabled(false) //false by default
             .rootPass("SET_YOUR_PASSWORD") // password for your linode
         .build();
 
 api.createLinode(createRequest);
 
 //Assuming a fictional linode id
 final int linodeId = 1234; 
 api.deleteLinode(linodeId);
```

# Handling errors #

First, go through [this](https://developers.linode.com/v4/errors) guide. Following RESTFUL principles, Linode returns Http 4xx or 5xx error code
to indicate error. In such a case, linode4j would throw `LinodeException`, which extends RuntimeException(thus sparing you them checked exceptions).
 
```java
//Same code as above
    try{
        api.createLinode(createRequest);
    }
    catch(final LinodeException ex){
        log.error("", ex);
    }
``` 

# Methods #

1. Linode

```java
Page<Linode> getLinodes(int pageNo);
Linode getLinodeById(int linodeId);
void createLinode(LinodeCreateRequest request);
void deleteLinode(int linodeId);
void bootLinode(int linodeId);
void bootLinode(int linodeId, Integer configId);
void cloneLinode(int linodeId, LinodeCloneRequest request);
void kvmifyLinode(int linodeId);
void mutateLinode(int linodeId);
void rebootLinode(int linodeId);
void rebootLinode(int linodeId, Integer configId);
LinodeRebuildResponse rebuildLinode(int linodeId, LinodeRebuildRequest request);
void rescueLinode(int linodeId, Devices devices);
void resizeLinode(int linodeId, String linodeType);
void shutdownLinode(int linodeId);
Page<BlockStorageVolume> getBlockStorageVolumesByLinodeId(int linodeId);
```

2. Linode Types

```java
Page<LinodeType> getLinodeTypes(int pageNo);
LinodeType getLinodeTypeById(String linodeTypeId);
```

3. Kernel

```java
Page<Kernel> getKernels(int pageNo);
Kernel getKernelById(String id);
```

4. Image

```java
Page<Image> getImages(int pageNo);
Image getImageById(int imageId);
void deleteImage(int imageId);
```

5. Account, Invoice, Notifications

```java

Page<AccountEvent> getAccountEvents(int pageNo);
AccountEvent getAccountEventById(int accountEventId);
void markAccountEventAsRead(int accountEventId);
void markAccountEventsAsSeen(int accountEventId);
Page<Invoice> getInvoices(int pageNo);
Invoice getInvoiceById(int invoiceId);
Page<InvoiceItem> getInvoiceItemsByInvoiceId(int invoiceId);
Page<AccountNotification> getAccountNotifications(int pageNo);
```

6. Regions

```java
Page<Region> getRegions(int pageNo);
Region getRegionById(String regionId);
```

7. Volumes
```java
Page<BlockStorageVolume> getVolumes(int pageNo);
BlockStorageVolume getVolumeById(int volumeId);
void createVolume(BlockStorageVolumeCreateRequest request);
void deleteVolume(int volumeId);
void attachVolumeToLinode(int volumeId, BlockStorageVolumeAttachRequest request);
void cloneVolume(int volumeId, String label);
void detachVolume(int volumeId);
```

8. Profile, Grants, Authorized Apps, Tokens 
```java

Page<AuthorizedApp> getAuthorizedApps(int pageNo);
AuthorizedApp getAuthorizedAppById(int authorizedAppId);
void deleteAuthorizedApp(int authorizedAppId);
Profile getProfile();
ProfileGrants getProfileGrants();
void changeProfilePassword(String password);
Page<ProfileToken> getProfileTokens(int pageNo);
ProfileToken getProfileTokenById(int tokenId);

```

# Contribute #

Contributions are welcome, and are subject to the following guidelines:

1. This project relies heavily on Lombok for type inference(`val` keyword), `@Builder` to use Builder design pattern, 
and `@Data` for getters, equals, hashcode and toString

2. Jackson is used for Json marshalling/unmarshalling. To deserialize enums, create a custom class that extends `JsonDeserializer<T>` and 
annotate the enum with this class

3. Model classes **must** be immutable

# Changelog

* v1.1
    
    * endpoints for Volume
    * Javadocs
    * very initial documentation
    * Removed distribution from few objects as per [linode's changelogs](https://developers.linode.com/v4/changelogs)