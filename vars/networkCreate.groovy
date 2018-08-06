def call(String name = 'undef') {

try{
        def STATE = sh (
            script: "docker network inspect ${name}",
            returnStatus: true )
            echo "STATE=$STATE"
            if ( "$STATE" == '1' ){
                sh "echo 'NO EXISTE NETWORK ${name}'"
                sh "docker network create ${name}"
            }
    }catch (Exception err) {
    		sh "echo 'NO EXISTE'"
    		currentBuild.result = 'SUCCESS'
    }
}//end stop