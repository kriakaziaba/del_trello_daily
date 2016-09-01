/**
 * Created by DiR on 31.08.2016.
 */

import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.RESTClient
import oauth.signpost.*
import oauth.signpost.basic.*

/**
 * Created by DiR on 31.08.2016.
 */


def key = 'f742b27417858c53a1758c29a694f0f8'
def keySecret = 'c4e7f84aafef2d19292268c391fe70aaf84ddfc390d523b9c43e0e89e01ca4f1'
def requestTokenUrl = 'https://trello.com/1/OAuthGetRequestToken'
def authorizeUrl = 'https://trello.com/1/OAuthAuthorizeToken'
def accessTokenUrl = 'https://trello.com/1/OAuthGetAccessToken'
def pin = '1c82ab667d1421b22b21711a22779b94'

consumer = new DefaultOAuthConsumer(key, keySecret)
provider = new DefaultOAuthProvider(
        requestTokenUrl,
        accessTokenUrl,
        authorizeUrl);
println provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND) + '&scope=read,write&expiration=30days&name=groovytrelloxuy'
// copy the above line, paste it in your browser; Twitter will ask you to authorize...
provider.retrieveAccessToken(consumer, pin)
println consumer.token //<YOUR ACCESS TOKEN>
println consumer.tokenSecret //<YOUR SECRET TOKEN>

def client = new RESTClient( 'https://api.trello.com/' )
client.auth.oauth key, keySecret, consumer.token, consumer.tokenSecret
HttpResponseDecorator lol = client.get( path : '1/members/me/boards' )
assert lol.status == 200