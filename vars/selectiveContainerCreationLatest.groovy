def call(Map args) {
  podTemplate(containers: [
    containerTemplate(name: 'java', image: 'openjdk:17-ea-10-jdk', ttyEnabled: true, command: 'cat'),
    containerTemplate(name: 'maven', image: 'maven:3.3.9-jdk-8-alpine', ttyEnabled: true, command: 'cat'),
  ]) {

  }
}
