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
