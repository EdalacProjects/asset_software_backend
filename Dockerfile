FROM ubuntu:22.04
RUN apt-get update -y && apt-get upgrade -y && apt-get autoremove -y

RUN groupadd --gid 1000 app && useradd --uid 1000 --gid app --shell /bin/bash --create-home app

RUN apt install openjdk-17-jdk -y && apt install openjdk-17-jre -y
ENV TZ=America/Bogota
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime 
RUN apt-get install git -y &&  apt-get install tzdata -y
RUN apt install maven -y

EXPOSE 8080 9090

RUN mkdir /app && mkdir /source
RUN chown 755 app:app /source && chown 755 app:app /app
#COPY /src/ /source/src
#COPY /pom.xml /source
WORKDIR /source
RUN git clone https://edalac2003:'.edw1n.s0p0rt3'@github.com/EdalacProjects/asset_software_backend.git
WORKDIR /source/asset_software_backend
RUN mvn clean install -Dmaven.test.skip=true
COPY target/asset_software*.jar /app
COPY startup.sh /app

#RUN rm -Rf /source/*

USER app

ENTRYPOINT ["/bin/sh", "-c", "bash"]