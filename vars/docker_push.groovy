def call(String ProjectName, String ImageTag, String DockerHubUser) {

    withCredentials([
        usernamePassword(
            credentialsId: 'docker',
            usernameVariable: 'dockerhubuser',
            passwordVariable: 'dockerhubpass'
        )
    ]) {

        sh """
            echo \$dockerhubpass | docker login -u \$dockerhubuser --password-stdin
            docker push ${DockerHubUser}/${ProjectName}:${ImageTag}
        """
    }
}
