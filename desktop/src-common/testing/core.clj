(ns testing.core
  (:require [play-clj.core :refer :all]
            [play-clj.ui :as ui]
            [play-clj.g2d :as g2d]))

(defscreen main-screen
  :on-show
  (fn [screen entities]
    (update! screen :renderer (stage))
    (g2d/texture "logo.png"))

  :on-render
  (fn [screen entities]
    (clear!)
    (render! screen entities)))

(defgame testing-game
  :on-create
  (fn [this]
    (set-screen! this main-screen)))
