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

### Building Docker Image using Ansible Playbook
```
cd ~/devops-nov-2021
git pull
cd Day4/Ansible/CustomDockerImage
ansible-playbook build-docker-image-playbook.yml -e ansible_become_user=root --ask-become-pass
```

### Provisioning Docker Containers using Ansible Playbook
```
cd ~/devops-nov-2021
git pull
cd Day4/Ansible
ansible-playbook provision-docker-containers-playbook.yml
```

### What is Prometheus?
- Prometheus a tool that collects performance metrics

### What is Grafana?
- Grafana is a tool that plots any data given in graphical fashion
- supports variety of graphs, pie-chart, bar-chart, etc.,

### Using Prometheus/Grafana to collect Jenkins performance metrics 

0. Install Prometheus metrics Plugin in Jenkins
1. Installing Prometheus
2. Configuring Prometheus to collect performance metrics from Jenkins
3. Installing Grafana
4. Configuring Grafana to collect metrics and data from Prometheus and plot the data in an impression dashboard


### Accessing the Jenkins Performance Metrics from Jenkins
```
http://localhost:8080/prometheus
```

### Creating Prometheus Container
```
docker run -d --name prometheus -p 9090:9090 prom/prometheus:0.18.0
```

### Copy the prometheus config file from container to local machine and add a prometheus jenkins job
```
docker cp prometheus:/etc/prometheus/prometheus.yml .
```

### Append the below to the prometheus.yml file copied from the prometheus container
<pre>
- job name: 'jenkins'
  scrape_interval: 5s
  metrics_path: /prometheus
  target_groups:
     - targets: ['192.168.22.233:8080']
</pre>

You may now copy the updated prometheus.yml back to the container
```
docker cp prometheus.yml prometheus:/etc/prometheus/prometheus.yml 
docker restart prometheus
```

See if the prometheus container is still running after applying the config changes
```
docker ps
```

You may now access the prometheus dashboard on your favourite browser at http://localhost:9090.
You can check the status menu in Prometheus to verify if Prometheus is able to collect data from Jenkins.

### Creating Grafana container
```
docker run -d --name grafana -p 3000:3000 -e GF_SECURITY_ADMIN_PASSWORD=grafana grafana/grafana:latest
```
You can access the grafana page at http://localhost:3000

You need to create a Datasource to pull data from Prometheus.
Prometheus URL you need to provide is <your-rps-lab-machine-ip>:9090

You may now import Dashboard ID 9964 and connect with Prometheus Datasource to view an impressive Grafana Dashboard that plots live performance data from Jenkins.
