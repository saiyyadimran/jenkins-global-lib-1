def call(Map args) {
  podTemplate(containers: [
    containerTemplate(name: 'java', image: 'openjdk:17-ea-10-jdk', ttyEnabled: true, command: 'cat'),
    containerTemplate(name: 'maven', image: 'maven:3.3.9-jdk-8-alpine', ttyEnabled: true, command: 'cat'),
  ]) {

    node(POD_LABEL) {
        stage('Get a Java project') {
            git 'https://github.com/jenkinsci/kubernetes-plugin.git'
            container('java') {
                stage('Check java version') {
                    sh 'java -version'
                }
            }
        }
        stage('Get a Maven project') {
            git 'https://github.com/jenkinsci/kubernetes-plugin.git'
            container('maven') {
                stage('Build a Maven project') {
                    sh 'mvn -B clean install'
                }
            }
        }

    }
  }
}
