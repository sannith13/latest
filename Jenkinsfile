pipeline
{
    agent any
    environment {
        path = "/usr/local/src/apache-maven/bin:$path"
       
    }
    
    
    stages
    {
        stage("git checkout")
        {
            steps
            {
              git 'https://github.com/sannith13/latest.git'  
            }
            
        }
        stage("maven build")
        {
            steps
            {
                sh "mvn -v"
                
                 tool name: 'maven', type: 'maven'
                  
                
                
                
            }
        }
    }
}

