FROM ubuntu:18.04

RUN apt-get update \
    && apt-get -y install apt-transport-https ca-certificates curl gnupg-agent software-properties-common \
    && apt-get -y install wget curl zip unzip sudo

# Install Docker
RUN apt-get update \
    && curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add - \
    && sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu  $(lsb_release -cs) stable" \
    && apt-get update \
    && apt-get install -y docker-ce docker-ce-cli containerd.io

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

#ENTRYPOINT ["/bin/bash", "-c"]

CMD ["/bin/bash"]
