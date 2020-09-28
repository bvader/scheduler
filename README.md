
# scheduler

A simple Spring Boot non-interactive application to test Elastic APM and correlated logging. 

To change the rate edit the `ScheduledTasks` class and change the `@Scheduled` annotation, note this is in `ms`. 

`@Scheduled(fixedRate = 200)`

```
git clone https://github.com/bvader/scheduler.git
cd scheduler
./mvnw clean package -Dmaven.test.skip=true
cf push
```

You can run with local ELK stack as well.
`./run-w-apm.sh`
