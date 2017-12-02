module.exports = {
    entry: [ "./web-src/index.tsx" ],
    output: {
        filename: "bundle.js",
        path: __dirname + "/content/dist"
    },

    // Enable sourcemaps for debugging webpack's output.
    devtool: "source-map",

    resolve: {
        // Add '.ts' and '.tsx' as resolvable extensions.
        extensions: [".ts", ".tsx", ".js", ".json", ".css", ".scss"]
    },

    module: {
        rules: [

            {
                test: /\.css$/,
                use: [
                    "style-loader",
                    {
                        loader: 'typings-for-css-modules-loader',
                        query: {
                            modules: true,
                            importLoaders: 1,
                            camelCase: true,
                            namedExport: true,
                            localIdentName: '[name]_[local]_[hash:base64:5]'
                        }
                    }]
            },

            {
                test: /\.scss$/,
                use: [
                    "style-loader",
                    {
                        loader: 'typings-for-css-modules-loader',
                        query: {
                            modules: true,
                            importLoaders: 1,
                            camelCase: true,
                            namedExport: true,
                            localIdentName: '[name]_[local]_[hash:base64:5]'
                        }
                    },
                    "sass-loader"]
            },

            // All files with a '.ts' or '.tsx' extension will be handled by 'awesome-typescript-loader'.
            { test: /\.tsx?$/, loader: "awesome-typescript-loader" },

            // All output '.js' files will have any sourcemaps re-processed by 'source-map-loader'.
            { enforce: "pre", test: /\.js$/, loader: "source-map-loader" }
        ]
    },

    // When importing a module whose path matches one of the following, just
    // assume a corresponding global variable exists and use that instead.
    // This is important because it allows us to avoid bundling all of our
    // dependencies, which allows browsers to cache those libraries between builds.
    externals: {
        "react": "React",
        "react-dom": "ReactDOM"
    },
};