pipeline {
    agent any

    parameters {
        string(name: 'TAG', defaultValue: '@contact', description: 'Tag to execute')
    }

    stages {
        stage('Build & Test') {
            steps {
                bat "gradlew.bat clean test -Dcucumber.filter.tags=${params.TAG}"
            }
        }
    }
}