# DevOps

### What is Continuous Integration?
- Team should check-in the code several times a day
- Developers, QA and Operations Team

- Development Team
   - write application code
   - write automated unit and integration test cases(code)
   - TDD
      - Junit, Mockito, PowerMock, NUnit , Moq, CppUnit, gtest, gmock

- QA Team
   - write automated functionality test, component test, API test, stress, load, performance test, etc
   - automated cases involves writing test cases as source code
   - Behaviour Driven Development
       - Cucumber, Specflow, Jasmine, Karma, etc

- Operations Team
   - Docker Images (Infrastruce as code)
   - Ansible (Infrastruce as code)
   - Terraform, Cloudformation, Kubernetes Manifest file


### What is Continuous Deployment?
 - Continuously deploying product release to QA environment, pre-production, staging environment, etc


### What is Continuous Delivery?
 - Continuously delivery the tested releases to customer environment, it could be staging servers or even live prod server


### Jenkins
 - Continuous Integration Build Server
 - Developed in Java by Joshuke Gawakuchi, a former Sun Microsystems Employee
 - The initial name of the product was called Hudson
 - Sun Microsystems was then acquired by Oracle
 - the Hudson got split into 2 teams
 - the Hudson stayed back with Oracle, while the other part of the Hudson team, created a branch for Hudson called Jenkins and they came out of Oracle. 
 - today both Hudson and Jenkins are open source
 - Hudson is mainted by Oracle while Jenkins is maintained by Cloudbees founded by Joshuke Gawakuchi
 - Enterprise Edition of Jenkins is called Cloudbees and opensource variant is called Jenkins.
 - Alternate CI Servers
     - Bamboo
     - TeamCity
     - Microsoft Team Foundation Server(TFS)


### Setting up Jenkins
You may launch jenkins as shown below from the terminal as rps user
```
java -jar ./jenkins.war
```
When prompted for initial admin password, you may copy/paste the initial admin password from the /home/rps/.jenkins/secrets/initialAdminPassword

As the jenkins is launched in interactive fashion, pressing Ctrl+c will terminate hence use a different Terminal Tab and leave this terminal undisturbed.

We need to choose "Install Suggested Plugins" and then later need to manually install the below plugins
1. Docker
2. Maven Integration
3. Build Pipeline
4. Ansible
5. Ansible Tower(optional - required in case you wish to integrate Ansible Tower with Jenkins)

You also need to create a user once the plugins are installed.
