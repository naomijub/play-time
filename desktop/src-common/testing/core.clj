(ns testing.core
  (:require [play-clj.core :refer :all]
            [play-clj.ui :as ui]
            [play-clj.g2d :as g2d]
            [testing.input :as input]))

(defscreen main-screen
  :on-show
  (fn [screen entities]
    (update! screen :renderer (stage))
    [(assoc (g2d/texture "logo.png")
      :x 10 :y 10 :width 40 :height 40)
     (assoc (g2d/texture "javalogo.png")
      :x 400 :y 400 :width 40 :height 40)])

  :on-key-down
  (fn [screen entities]
    (cond
      (= (:key screen) (key-code :dpad-up))
      (input/move (first entities) :up)
      (= (:key screen) (key-code :dpad-down))
      (input/move (first entities) :down)
      (= (:key screen) (key-code :dpad-right))
      (input/move (first entities) :right)
      (= (:key screen) (key-code :dpad-left))
      (input/move (first entities) :left)))

  :on-render
  (fn [screen entities]
    (clear!)
    (render! screen entities)))

(defgame testing-game
  :on-create
  (fn [this]
    (set-screen! this main-screen)))
