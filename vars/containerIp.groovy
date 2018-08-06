def call(String name = 'undef') {

try{    def IP = new String()
        IP = sh (
            script: "docker inspect --format='{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' ${name}",
            returnStdout: true ).trim()
            return IP
    }catch (Exception err) {
    		sh "echo 'NO EXISTE'"
    		currentBuild.result = 'SUCCESS'
    }
}//end stop