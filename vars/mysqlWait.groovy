#!groovy
def call(String name = 'undef') {
    waitUntil {
        String r = sh (
            script: "docker inspect --format '{{json .State.Health.Status }}' ${name} ",
             returnStdout : true).trim()
        echo "valor $r"
        if ( "$r" == "\"healthy\"" ){ 
            echo "valor rTRUE $r"
            return true
        }else {
            echo "valor rFALSE $r"
            return false
        }
    }//end waitUntil
}//end call