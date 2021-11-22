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
