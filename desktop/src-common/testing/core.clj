(ns testing.core
  (:require [play-clj.core :refer :all]
            [play-clj.ui :as ui]))

(defscreen main-screen
  :on-show
  (fn [screen entities]
    (update! screen :renderer (stage))
    (ui/label "Clojure shall conquer the world!!!" (color :white)))

  :on-render
  (fn [screen entities]
    (clear!)
    (render! screen entities)))

(defgame testing-game
  :on-create
  (fn [this]
    (set-screen! this main-screen)))
