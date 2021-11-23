# Ansible 

### Ansible Overview
- What is Ansible?
   - configuration management tool
       - it is tool used by System Administrators to automate software installations
         on on-prem, cloud servers, virtual machines, containers, etc
       - Examples
           - Puppet - DSL is Ruby
                - PULL based architecture
                - requires a proprietary agent running on the nodes
           - Chef - DSL is Ruby
                - PULL based architecture
                - requires a proprietary agent running on the nodes
           - Salt(aka SaltStack)
           - Ansible - DSL is YAML (Yet Another Markup Language - superset of JSON)
		- PUSH based architecture
		- agentless
		- easy to setup
		- easy to learn 
		- is developed in Python
                - Unix/Linux/Mac - it expects SFTP/SCP to be running
                - Unix/Linux/Mac - it expects SSH Server to be running
		- uses modules to automate


### Let's generate key pair for rps user
```
ssh-keygen
```
Accept all defaults by hitting enter key(thrice).

#### Creating custom ubuntu ansible node Docker Image
```
cd ~/devops-nov-2021
git pull
cd Day3/Ansible/ubuntu-ansible
cp ~/.ssh/id_rsa.pub authorized_keys
docker build -t tektutor/ansible-ubuntu .
```

### Let's create couple of containers using our custom docker image
```
docker run -d --name ubuntu1 --hostname ubuntu1 -p 2001:22 -p 8001:80 tektutor/ansible-ubuntu 
docker run -d --name ubuntu2 --hostname ubuntu2 -p 2002:22 -p 8002:80 tektutor/ansible-ubuntu 
```
We will be using the ubuntu1 and ubuntu2 containers as our Ansible Nodes.  Technically speaking ubuntu1 and ubuntu2 could also be an on-prem server, cloud server, virtual machines, or a combination of them, etc

### Let's test if we are able SSH into the containers without supplying password as rps user
```
ssh -p 2001 devops@localhost
ssh -p 2002 devops@localhost
```
The expected output is
<pre>
[rps@localhost ubuntu-ansible]$ ssh -p 2001 devops@localhost
The authenticity of host '[localhost]:2001 ([::1]:2001)' can't be established.
ECDSA key fingerprint is SHA256:RILXJPejzluv/gCdlD8tTmyNEqQbv+CcINgeM+H+Ny0.
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added '[localhost]:2001' (ECDSA) to the list of known hosts.
Welcome to Ubuntu 16.04.7 LTS (GNU/Linux 4.18.0-305.12.1.el8_4.x86_64 x86_64)

 * Documentation:  https://help.ubuntu.com
 * Management:     https://landscape.canonical.com
 * Support:        https://ubuntu.com/advantage

The programs included with the Ubuntu system are free software;
the exact distribution terms for each program are described in the
individual files in /usr/share/doc/*/copyright.

Ubuntu comes with ABSOLUTELY NO WARRANTY, to the extent permitted by
applicable law.

devops@ubuntu1:~$ exit
logout
Connection to localhost closed.
</pre>
