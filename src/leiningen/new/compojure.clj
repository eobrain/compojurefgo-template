(ns leiningen.new.compojure
  (:use [leiningen.new.templates :only [renderer sanitize year ->files]]))

(defn compojure
  "Create a new Compojure project"
  [name]
  (let [data {:name name
              :sanitized (sanitize name)
              :year (year)}
        render #((renderer "compojure") % data)]
    (->files data
             [".gitignore"  (render "gitignore")]
             ["project.clj" (render "project.clj")]
             ["README.md"   (render "README.md")]
             ["src/{{sanitized}}/handler.clj" (render "handler.clj")])))