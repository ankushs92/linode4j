# linode4j #

![travis!](https://travis-ci.org/ankushs92/linode4j.svg?branch=master "travis")
[![Coverage Status](https://coveralls.io/repos/github/ankushs92/linode4j/badge.svg?branch=master)](https://coveralls.io/github/ankushs92/linode4j?branch=master)

linode4j is a Java library for [Linode's V4 REST API](https://developers.linode.com/v4). Currently, it covers almost all endpoints with the exception of
[Profile](https://developers.linode.com/v4/reference/profile).

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
 
1. Get Linodes

```java
    final int pageNo = 1;
    final Page<Linode> paginatedLinodes = linodeClient.getLinodes(pageNo);

    //Get the linode
    final Set<Linode> linodes = paginatedLinodes.getContent();
    System.out.println(linodes);
    System.out.println(paginatedLinodes.getCurrentPageCount());
    System.out.println(paginatedLinodes.getTotalPages());
    System.out.println(paginatedLinodes.getTotalResults());
```