FROM ubuntu:18.04

MAINTAINER Savva Genchevskiy

ENV DEBIAN_FRONTEND noninteractive

RUN apt-get update \
    && apt-get -y install apt-transport-https ca-certificates curl gnupg-agent software-properties-common \
    && apt-get -y install wget curl zip unzip \
    && apt-get install -y apt-utils net-tools \
    && apt-get install -y sudo \
    && apt-get install -y --reinstall systemd

# Install Chrome
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN dpkg -i google-chrome-stable_current_amd64.deb; apt-get -fy install

#SHELL ["/bin/bash", "-c"]
# Install OpenJDK-8
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk && \
    apt-get install -y ant && \
    apt-get clean;

# Fix certificate issues
RUN apt-get update && \
    apt-get install ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f;

# Setup JAVA_HOME -- useful for docker commandline
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
RUN export JAVA_HOME

RUN java -version

# Install Gradle
RUN apt-get update \
    && apt-get install -y gradle


EXPOSE 5901

ENTRYPOINT ["/usr/bin/env", "bash", "-c"]


#ENTRYPOINT ["/bin/bash", "-c"]

#CMD ["/bin/bash"]
