# linode4j #

![travis!](https://travis-ci.org/ankushs92/linode4j.svg?branch=master "travis")

linode4j is a Java library for [Linode's V4 REST API](https://developers.linode.com/v4). 

# Get Token #

The way to authenticate with Linode is via a [OAuth](https://developers.linode.com/v4/access) token.
Here is what you need to do to get the token :

1. [Login](https://cloud.linode.com/linodes) to linode
2. Click on your profile icon on the top right
3. Go to 'My Profile'
4. Click on 'Api Tokens'
5. Click the button 'Create a Personal Access Token'


# Get Started #

Create an instance of `LinodeApiClient` to interact with Linode.

```java
    final String token = "YOUR_TOKEN";
    //Connect with Linode
    final LinodeApiClient linodeClient = new LinodeApiClient(oauthToken);
    
```

**Node** Refer to the [Pagination](https://developers.linode.com/v4/pagination) guide to understand how linode implements pagination. A GET request for a collection of objects(for example, a collection of linodes registered with your account) returns the collection along with paging parameters.
The default page size is 25. When requesting for collection of objects, it is mandatory to pass in a `pageNo`.
To view the first 25 collections, therefore, set pageNo = 1 
 
For example, here is how you get a paginated list of linodes created by your account:

```java
        final int pageNo = 1;
        //Get Linodes along with paging parameters
        final Page<Linode> pagedLinodes = api.getLinodes(pageNo);

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
            //Etc
        }
```

Here is how you create a Linode:

```java


```


# Future work #

Currently, linode4j covers almost all endpoints with the exception of [Profile](https://developers.linode.com/v4/reference/profile).
Also, searching by fields that have been marked as [filterable](https://developers.linode.com/v4/filtering) is yet to be implemented.
I'll get to it when I get time. Feel free to send a PR! :)
