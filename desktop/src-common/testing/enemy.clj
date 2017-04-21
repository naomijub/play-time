(ns testing.enemy
  (:require [play-clj.g2d :as g2d]))


(defn create-kotlin
  []
  (assoc (g2d/texture "kotlinlogo.png")
  :x 350 :y 350 :width 40 :height 40))
