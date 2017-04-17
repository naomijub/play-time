(ns testing.core
  (:require [play-clj.core :refer :all]
            [play-clj.ui :as ui]
            [play-clj.g2d :as g2d]))

(defscreen main-screen
  :on-show
  (fn [screen entities]
    (update! screen :renderer (stage))
    (assoc (g2d/texture "logo.png")
      :x 10 :y 10 :width 20 :height 20))

  :on-key-down
  (fn [screen entities]
    (cond
      (= (:key screen) (key-code :dpad-up))
      (println "up")
      (= (:key screen) (key-code :dpad-down))
      (println "down")
      (= (:key screen) (key-code :dpad-right))
      (println "right")
      (= (:key screen) (key-code :dpad-left))
      (println "left")))

  :on-render
  (fn [screen entities]
    (clear!)
    (render! screen entities)))

(defgame testing-game
  :on-create
  (fn [this]
    (set-screen! this main-screen)))
