(ns testing.core
  (:require [play-clj.core :refer :all]
            [play-clj.ui :refer :all]))

(defscreen main-screen
  :on-show
  (fn [screen entities]
    (update! screen :renderer (stage))
    (label "Bloba Games!" (color :white)))

  :on-render
  (fn [screen entities]
    (clear!)
    (render! screen entities)))

(defgame testing-game
  :on-create
  (fn [this]
    (set-screen! this main-screen)))
