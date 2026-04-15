pipeline {
    agent any

    parameters {
        string(
            name: 'TAG',
            defaultValue: '@contact',
            description: 'Tag de Cucumber a ejecutar. Ejemplos: @contact, @smoke, @regression'
        )
    }

    stages {
        stage('Build & Test by Tag') {
            steps {
                echo "Ejecutando tests con tag: ${params.TAG}"
                bat "gradlew.bat clean test -Dcucumber.filter.tags=\"${params.TAG}\""
            }
        }
    }

    post {
        always {
            echo 'Pipeline finalizado.'
            archiveArtifacts artifacts: 'build/reports/**', allowEmptyArchive: true
        }
        success {
            echo "Ejecución exitosa para el tag: ${params.TAG}"
        }
        failure {
            echo "La ejecución falló para el tag: ${params.TAG}"
        }
    }
}