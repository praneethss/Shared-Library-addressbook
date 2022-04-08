def call() {
 
    checkout([
        $class: 'GitSCM',
        branches: [[name: '*/master']],
        userRemoteConfigs: [[ url: "https://github.com/praneethss/addressbook.git" ]]
    ])
}
