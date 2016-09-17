# Publish markdown text on wordpress when pushing to github

*Spring Boot Application which reacts to github notifications (e.g. commits on a specific branch on a specific 
repository) and which loads the raw text of the changed markdown and posts it to a configured wordpress instance* 

## Status:

Work in progress:
* Accepts Github Commit Notification POST Request
* Is able to extract some data from the sent JSON

## Howto:

* Download the [ngrok](https://ngrok.com/) application to allow github to make a post request to your local spring boot application
* Create a dummy repository on github for testing purposes
* Start ngrok (e.g. *./ngrok http 4567* ) and copy the provided public internet address for your associated local service
* [Create a webhook](https://github.com/stefanesterer/derstefon-test/settings/hooks/new) for this repository (e.g. for push events in our case). Specify the url provided by ngrok as the Payload URL
* Start the local application on the right port (e.g. 4567)

## Todos: 

* fix maven build
* Read all the necessary information out of the json, collect the modified *.md files and try to upload them to wordpress