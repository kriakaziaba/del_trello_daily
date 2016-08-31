/**
 * Created by DiR on 31.08.2016.
 */
import groovyx.net.http.RESTClient
import oauth.signpost.*
import oauth.signpost.basic.*

/**
 * Created by DiR on 31.08.2016.
 */


//f742b27417858c53a1758c29a694f0f8
//c4e7f84aafef2d19292268c391fe70aaf84ddfc390d523b9c43e0e89e01ca4f1
//auth
def key = 'f742b27417858c53a1758c29a694f0f8'
def keySecret = 'c4e7f84aafef2d19292268c391fe70aaf84ddfc390d523b9c43e0e89e01ca4f1'
def request_token_url = 'https://trello.com/1/OAuthGetRequestToken'
def authorize_url = 'https://trello.com/1/OAuthAuthorizeToken'
def access_token_url = 'https://trello.com/1/OAuthGetAccessToken'

consumer = new DefaultOAuthConsumer(key, keySecret)
provider = new DefaultOAuthProvider(
        request_token_url,
        access_token_url,
        authorize_url);
provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND);
// copy the above line, paste it in your browser; Twitter will ask you to authorize...
provider.retrieveAccessToken(consumer, '<PIN NUMBER FROM BROWSER>')
println consumer.token //<YOUR ACCESS TOKEN>
println consumer.tokenSecret //<YOUR SECRET TOKEN>

def client = new RESTClient( 'https://trello.com/' )
client.auth.oauth key, keySecret, consumer.token, consumer.tokenSecret
assert client.get( path : '/1/members/me/boards ' ).status == 200