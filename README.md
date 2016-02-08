# Microservices Meetup Hamburg 

## Hosted at ePages (Feb 3rd, 2016)

Slides: [http://epages-de.github.io/meetup-2016-02-slides/]

### Code Example

Creates two microservices (`kitten` and `food`), demonstrating service discovery by using Kubernetes.  
`master` includes the full source, and `kitten-start` is the base branch used for the code demo.

The project has preliminary docker support, although we are recommending to use the 
really good [gradle plugin](https://github.com/bmuschko/gradle-docker-plugin).

The other service in charge is the `spring-cloud-config` server, which should be launched using our sample
[config repository](https://github.com/otrosien/meetup-2016-02-config-repo).
