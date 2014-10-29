(ns leiningen.new.compojurefgo
  (:require [leiningen.core.main :as main]
            [leiningen.new.templates :refer [renderer year project-name
                                             ->files sanitize-ns name-to-path
                                             multi-segment]]))

(def render (renderer "compojurefgo"))

(defn compojurefgo
  "Create a new Compojure Funcgo project"
  [name]
  (let [main-ns (multi-segment (sanitize-ns name))
        data    {:raw-name    name
                 :name        (project-name name)
                 :namespace   main-ns
                 :dirs        (name-to-path main-ns)
                 :year        (year)}]
    (->files data
             [".gitignore"  (render "gitignore")]
             ["project.clj" (render "project.clj" data)]
             ["README.md"   (render "README.md" data)]
             ["src/{{dirs}}/handler.go"       (render "handler.go" data)]
             ["test/{{dirs}}/handler_test.go" (render "handler_test.go" data)]
             "resources/public")))
