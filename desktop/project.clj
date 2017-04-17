(defproject testing "0.0.1-SNAPSHOT"
  :description "Clojure for the Brave and True?"

  :dependencies [[com.badlogicgames.gdx/gdx "1.9.3"]
                 [com.badlogicgames.gdx/gdx-backend-lwjgl "1.9.3"]
                 [com.badlogicgames.gdx/gdx-box2d "1.9.3"]
                 [com.badlogicgames.gdx/gdx-box2d-platform "1.9.3"
                  :classifier "natives-desktop"]
                 [com.badlogicgames.gdx/gdx-bullet "1.9.3"]
                 [com.badlogicgames.gdx/gdx-bullet-platform "1.9.3"
                  :classifier "natives-desktop"]
                 [com.badlogicgames.gdx/gdx-platform "1.9.3"
                  :classifier "natives-desktop"]
                 [org.clojure/clojure "1.7.0"]
                 [play-clj "1.1.1"]
                 [expectations "2.2.0-beta1"]]

  :source-paths ["src" "src-common"]
  :javac-options ["-target" "1.6" "-source" "1.6" "-Xlint:-options"]
  :aot [testing.core.desktop-launcher]
  :main testing.core.desktop-launcher
  :profiles
  {:dev {:dependencies [[proto-repl "0.3.1"]]
         :plugins [[com.jakemccrary/lein-test-refresh "0.19.0"]]}}
  :test-refresh {:growl false
                 :notify-on-success false
                 :quiet true
                 :changes-only true
                 :stack-trace-depth nil
                 :run-once false
                 :watch-dirs ["src" "src-common" "test-common"]
                 :refresh-dirs ["src" "src-common" "test-common"]})
