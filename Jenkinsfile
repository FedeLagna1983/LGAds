pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/FedeLagna1983/LGAds.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'gradlew clean test'
            }
        }
    }
}
