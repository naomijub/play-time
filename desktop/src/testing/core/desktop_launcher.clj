(ns testing.core.desktop-launcher
  (:require [testing.core :refer :all])
  (:import [com.badlogic.gdx.backends.lwjgl LwjglApplication]
           [org.lwjgl.input Keyboard])
  (:gen-class))

(defn -main
  []
  (LwjglApplication. testing-game "testing" 800 600)
  (Keyboard/enableRepeatEvents true))
