def call(String port = 'undef') {

try{    def IP = new String()
        IP = sh (
            script: "docker inspect --format='{{ (index (index .NetworkSettings.Ports "80/tcp") 0).HostPort }}' ",
            returnStdout: true ).trim()
            return IP
    }catch (Exception err) {
    		sh "echo 'NO EXISTE'"
    		currentBuild.result = 'SUCCESS'
    }
}//end stop