# Docker Commands

## Managing Docker Immages

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


## Managing Docker containers

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

## Creating a mysql container
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

## Volume Mounting
```
mkdir -p /tmp/mysql
docker run -d --name mysql1 --hostname mysq1 -v /tmp/mysql:/var/lib/mysql -e MYSQ_ROOT_PASSWORD=root mysql:latest 
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
exit
exit
```

### Remove the container now
```
docker rm -f mysql1
```

### Let's create a new mysql container and mount the same volume
```
docker run -d --name mysql2 --hostname mysq2 -v /tmp/mysql:/var/lib/mysql -e MYSQ_ROOT_PASSWORD=root mysql:latest 
```

### Let's get inside the mysql2 container
```
docker exec -it mysql2 sh
mysql -u root -p
SHOW DATABASE;
USE tektutor;
SELECT * FROM Training;
```
You should be able to see the tektutor database and Training records that you inserted via mysql1 containers.

### Remove any unwanted containers
```
docker rm -f $(docker ps -aq)
```

## Creating a LoadBalancer using nginx containers
```
docker run -d --name web1 --hostname web1 nginx:1.18
docker run -d --name web2 --hostname web2 nginx:1.18
docker run -d --name web3 --hostname web3 nginx:1.18
docker run -d --name lb --hostname lb -p 80:80 nginx:1.18
```

### We need to configure the lb container to work like a Load Balancer
```
docker cp lb:/etc/nginx/nginx.conf .
```
We need to edit the nginx.conf as shown below

<pre>
http {
    upstream backend {
        server 172.17.0.2;
        server 172.17.0.3:;
        server 172.17.0.4;
    }
    
    server {
        location / {
            proxy_pass http://backend;
        }
    }
}
</pre>

We need to copy the configured nginx.conf inside the lb as shown below
```
docker cp nginx.conf lb:/etc/nginx/nginx.conf
```

To apply the changes, we need to restart the container
```
docker restart lb
```

If all went well, lb container should be still running
```
docker ps
```

In order to identify which web server is serving the page, let's customize the index.html files in web1, web2 and web3 containers.
```
docker exec -it web1 sh
echo "Server 1" > /usr/share/nginx/html/index.html
exit

docker exec -it web2 sh
echo "Server 2 > /usr/share/nginx/html/index.html
exit

docker exec -it web3 sh
echo "Server 3 > /usr/share/nginx/html/index.html
exit
```

Let's see if the load balancer is able to forward the requests to web1, web2 and web3 containers in a round robin fashion.
```
curl http://localhost:80
curl http://localhost:80
curl http://localhost:80
```
You may replace localhost with your RPS Lab machine IP.
```
ifconfig ens192
```
