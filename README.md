#  GenesysCodingChallenge

Submission for coding challenge in relation to Associate SDET position

## Prerequisites
The following should be installed on local machine to run JAR:

[Docker](https://www.docker.com/)\
[Java](https://www.java.com/en/download/help/download_options.html)

To run and edit in IDE, this program also uses JUNIT and Selenium Frameworks.


## Running Tests

Once files are downloaded create a docker container by running the following in command prompt

```bash
docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome:3.141.59-20210128
```
Or to create a container with viewable by [VNCViewer](https://qxf2.com/blog/view-docker-container-display-using-vnc-viewer/) to watch the test being run

```bash
docker run -d -p 4444:4444 -p 5900:5900 -v /dev/shm:/dev/shm selenium/standalone-chrome-debug:3.141.59-20210128
```
Check to ensure container is running with 

```bash
docker ps
```

Once docker container is running navigate into the GenesysCodingChallenge folder and run

```bash
java -jar CodingChallenge.jar
```
If you wish to run the tests individually simpy open in IDE of choice or though CMD and run 'Test1' or 'Test2' as a JUNIT Test

