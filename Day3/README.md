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
