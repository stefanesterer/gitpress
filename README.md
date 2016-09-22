# Publish markdown text on wordpress when pushing to github

*Spring Boot Application which reacts to github notifications (e.g. commits on a specific branch on a specific 
repository) and which loads the raw text of the changed markdown and posts it to a configured wordpress instance* 

## Status:

Work in progress:
* Accepts Github Commit Notification POST Request
* Is able to extract some data from the sent JSON
* Is able to get the raw data of the added/modified *.md files from the git repository

## Howto:

* Download the [ngrok](https://ngrok.com/) application to allow github to make a post request to your local spring boot application
* Create a dummy repository on github for testing purposes
* Start ngrok (e.g. *./ngrok http 4567* ) and copy the provided public internet address for your associated local service
* [Create a webhook](https://github.com/stefanesterer/derstefon-test/settings/hooks/new) for this repository (e.g. for push events in our case). Specify the url provided by ngrok as the Payload URL
* Start the local application on the right port (e.g. 4567)
* Push to the repository and debug the application

## Todos: 

* connect the data to wordpress blog postings/pages ([via xml-rpc](https://codex.wordpress.org/XML-RPC_WordPress_API))
* add security (which urls can post to our service, use spring security with url restriction) / [secure with secret token](https://developer.github.com/webhooks/securing/)
* update wordpress with the new data
* insert debug/activity data into database
* create angular2 app to show debug/activity data and to allow configuration