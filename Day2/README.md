## Docker Commands

### Listing docker images from the local docker registry
```
docker images
```

### Downloading image from Docker Hub (Remote Docker registry )
```
docker pull hello-world:latest
docker pull ubuntu:16.04
```

### Deleting unwanted images from local registry
```
docker rmi hello-world:latest
```


### Managing Docker containers

### Creating docker containers in foreground(interactive) mode
```
docker run -it --name c1 --hostname c1 ubuntu:16.04 /bin/bash
docker run -it --name c2 --hostname c2 ubuntu:16.04 /bin/bash
```

### Listing currently running containers
```
docker ps
```

### Listing all containers irrespective of their running state
```
docker ps -a
```

### Renaming a container
```
docker rename c1 container-1
```

### Deleting an exited container 
```
docker rm -f container-1
```

### Deleting a running container graciously
```
docker stop c2
docker rm c2
```

### Let's create 3 containers
```
docker run -d --name c1 ubuntu:16.04 bash
docker run -d --name c2 ubuntu:16.04 bash
docker run -d --name c3 ubuntu:16.04 bash
```

### Deleting multiple containers
```
docker rm c1 c2 c3
```

### Deleting multiple containers forcibly
```
docker rm -f $(docker ps -aq)
```

### Deleting multiple containers graciously
```
docker stop $(docker ps -q)
docker rm $(docker ps -aq)
```

### Another way you can delete multiple containers
```
docker stop $(docker ps -q) && docker rm $(docker ps -aq)
```

### Getting inside a running container
```
docker exec -it c1 bash
```

### Stopping a running container
```
docker stop c1
```

### Starting a exited container
```
docker start c1
```

### Restarting a container
```
docker restart c1
```

### Checking application log in a container
```
docker logs c1
```

### Creating an nginx web server container
```
docker run -d --name web1 nginx:1.18
```

### Finding the IP Address of the web1 nginx container
```
docker inspect web1 | grep IPA
```

### You may also find the IP Address of a container this way
```
docker inspect -f "{{.NetworkSettings.IPAddress}}" web1
```

### Accessing the web page hosted on the web1 nginx container
Assuming 172.17.0.5 is the IP Address of the web1 container. Your web1 container IP address might be different.
```
curl http://172.17.0.5
```

### Creating a mysql container
```
docker run -d --name mysql1 --hostname mysq1 -e MYSQ_ROOT_PASSWORD=root mysql:latest 
```

### See if the mysql container is running
```
docker ps
```

### Getting inside the mysql1 container 
```
docker exec -it mysql1 sh
mysql -u root -p
```
When mysql prompts for password, type 'root' without quotes.

### You may then try the below SQL commands
```
SHOW DATABASES;
CREATE DATABASE tektutor;
USE tektutor;
CREATE TABLE Training ( id int, name VARCHAR(35), duration VARCHAR(25));
INSERT INTO Training VALUES ( 1, "DevOps", "5 Days" );
INSERT INTO Training VALUES ( 2, "Microservices", "5 Days" );
INSERT INTO Training VALUES ( 3, "Advanced Scala Programming", "5 Days" );
SELECT * FROM Training;
```
