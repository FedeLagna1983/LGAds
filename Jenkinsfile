pipeline {
    agent any

    stages {
        stage('Build & Test') {
            steps {
                bat 'gradlew.bat clean test'
            }
        }
    }
}