# Microservices Meetup Hamburg 

## Hosted at ePages (Feb 3rd, 2016)

### Code Example

Creates two microservices (`kitten` and `food`), demonstrating service discovery by using Kubernetes.  
`master` includes the full source, and `kitten-start` is the base branch used for the code demo.

The code does not demo how to create and publish the runtimes as docker images, but there
is a really good [gradle plugin](https://github.com/bmuschko/gradle-docker-plugin), which
can help you here.
