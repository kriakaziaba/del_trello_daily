/**
 * Created by DiR on 31.08.2016.
 */
import groovyx.net.http.RESTClient

//f742b27417858c53a1758c29a694f0f8
//auth
def key = 'f742b27417858c53a1758c29a694f0f8'
def client = new RESTClient( 'https://trello.com/' )
def resp = client.get(path: "1/authorize?expiration=1hour&name=forApiUsage&key=${key}")
assert resp
assert resp.status == 200  // HTTP response code; 404 means not found, etc.
println resp.getData()


//get next
//get in progress
//get done today
//send email
//change status of done today

