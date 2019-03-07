(defproject district0x/district-encryption "1.0.1-SNAPSHOT"
  :description "Set of functions helpful for data encryption on blockchain based on public/private key"
  :url "https://github.com/district0x/district-encryption"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[cljsjs/eccjs "0.3.1-0"]
                 [org.clojure/clojurescript "1.9.946"]]

  :npm {:dependencies [[eccjs "0.3.1"]]}

  :deploy-repositories [["snapshots" {:url "https://clojars.org/repo"
                                      :username :env/clojars_username
                                      :password :env/clojars_password
                                      :sign-releases false}]
                        ["releases"  {:url "https://clojars.org/repo"
                                      :username :env/clojars_username
                                      :password :env/clojars_password
                                      :sign-releases false}]]

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["deploy"]])
