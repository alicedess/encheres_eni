/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/main/resources/templates/**/*.html",
    "./src/main/resources/static/css/tailwind.css",
  ],
  theme: {
    extend: {
      colors: {
        primary: '#065996',
      },
    },
  },
  plugins: [],
}