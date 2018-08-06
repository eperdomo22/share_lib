def call(String name = 'undef') {

try{
        def GATEWAY = sh (
            script: "docker inspect --format='{{range .NetworkSettings.Networks}}{{.Gateway}}{{end}}' ${name}",
            returnStdout: true ).trim()
            echo "GATEWAY=$GATEWAY"
    }catch (Exception err) {
    		sh "echo 'NO EXISTE'"
    		currentBuild.result = 'SUCCESS'
    }
}//end stop