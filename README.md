1. 利用mybatis-generator生成model和dao还有mapper
```
mvn mybatis-generator:generate -e
```
2. 打包成jar包
```
mvn clean package -Dmaven.test.skip=true
```
3. 创建redis镜像
```
 docker run -p 6379:6379 -v $PWD/data:/data -d redis redis-server --appendonly yes
```
4. 创建mongodb镜像
```shell
#为了防止出现权限错误创建docker volume
$ docker volume create --name mongodata
#查看虚拟卷
$ docker volume ls
#连接运行数据库
$ docker run --name mongodb -v mongodata:/data/db -p 27017:27017 -d mongo:latest --auth
#创建账号
$ docker exec -it mongodb mongo admin
> db.createUser({ 
  user: 'root', 
  pwd: 'admin', 
  roles: [ { role: "userAdminAnyDatabase", db: "admin" } ] 
  });
#授权：1 代表授权验证成功
> db.auth("root","admin");
#可以use不存在的数据库，存入新数据时，mongoDB会自动创建这个数据库
> use iotdemo
> db.createUser({ 
  user: 'iotdemo', 
  pwd: 'iot123456', 
  roles: [ { role: "readWrite", db: "iotdemo" } ] 
  });
> db.auth("iotdemo","iot123456");
#重新登录数据库进行插入操作(需要先db.auth("iotdemo","iot123456"))
#插入db.collection.insert()
> db.foo.insert( { x: 1, y: 1 } )
#读取db.collection.find()
> db.foo.find()
```
搭建zookeeper:

> http://huangxubo.me/blog/zookeeper/zookeeper-docker-cluster/

有个地方报错了，通过`docker network ls`找到正确的network的名称：
```shell
docker run -it --rm \
        --link zoo1:zk1 \
        --link zoo2:zk2 \
        --link zoo3:zk3 \
        --net zk_cluster_default \
        zookeeper zkCli.sh -server zk1:2181,zk2:2181,zk3:2181
```