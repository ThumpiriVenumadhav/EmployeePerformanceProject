import React, { useEffect, useState } from "react";
import axios from "axios";
import { LineChart, Line, XAxis, YAxis, Tooltip, CartesianGrid, ResponsiveContainer } from "recharts";

const BellCurveChart = () => {
    const [chartData, setChartData] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8080/appraisals/bellcurve")
            .then(response => {
                const { "Expected Distribution": expected, "Actual Distribution": actual } = response.data;

                // Correct order: E → D → C → B → A
                const correctOrder = ["E", "D", "C", "B", "A"];

                // Format data for Recharts with the correct order
                const formattedData = correctOrder.map(key => ({
                    category: key,
                    Expected: parseInt(expected[key]),
                    Actual: parseInt(actual[key]),
                }));

                setChartData(formattedData);
            })
            .catch(error => console.error("Error fetching bell curve data:", error));
    }, []);

    return (
        <div style={{ textAlign: "center" }}>
            <h2>Bell Curve Analysis</h2>
            <ResponsiveContainer width="90%" height={400}>
                <LineChart data={chartData}>
                    <CartesianGrid strokeDasharray="3 3" />
                    <XAxis dataKey="category" />
                    <YAxis />
                    <Tooltip />
                    <Line type="monotone" dataKey="Expected" stroke="#8884d8" strokeWidth={2} dot={false} />
                    <Line type="monotone" dataKey="Actual" stroke="#82ca9d" strokeWidth={2} dot={false} />
                </LineChart>
            </ResponsiveContainer>

            {/* Labels Below the Graph */}
            <div style={{ display: "flex", justifyContent: "space-between", width: "80%", margin: "20px auto", fontSize: "18px", fontWeight: "bold" }}>
                <span style={{ color: "red" }}>Low Performers (E, D)</span>
                <span style={{ color: "blue" }}>Average Performers (C)</span>
                <span style={{ color: "green" }}>High Performers (B, A)</span>
            </div>
        </div>
    );
};

export default BellCurveChart;
