### What is XLR?
- it is product originally developed by XebiaLabs
- XLR - XL Release
- is used to create CI/CD Release Pipeline
- Digital AI acquired XebiaLabs

### What is XLD?
- it is a product developed by XebiaLabs
- XLD - XL Deploy
- helps in deploying application binaries to Dev/QA/Prod environments
- without write a single line of code you can make complex deployment to different
  environments

### Ansible
- Configuration management tool
- helps in automating software installation
- also has modules through which it can provision virtual machines on cloud like aws, gcp, containers
- also can be used to deploy binaries

### Container Orchestration Platform 
- it is a platform that manages containers
- scale up/down microservices independently
- rolling update 
   - upgrading your application from one version to other version without downtime
   - downgrade - i.e rollback from newer version to previous live version without i
     downtime
- has inbuilt monitoring facilities
   - monitors if all microservices/applications deployed with the orchestration
     platform are healthy and responding
   - when it detects any application/microservice non-responsive it will replace
     the faulty microservice/application with a new instance and ensure High Availabiulity
   - helps in exposing certain microservices/application to external world
   - helps in retaining certain application/microservices only for internal use
   - load balancing
- some examples
    - Docker SWARM - Only manages Docker
    - Google Kubernetes - Until now supports Docker as default Container Runtime but in the next upcoming releases they are planning to move to Podman
    - RedHat(IBM) OpenShift - by default uses Podman Container Runtime



