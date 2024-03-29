window.addEventListener('DOMContentLoaded', async (event) => {
        const source = "https://financialmodelingprep.com/api/v3/balance-sheet-statement/AAPL?period=annual&apikey=RslEVBRQCqRMloHRNgFZKgkM1UhHPCKM";
    
        try {
            const response = await fetch(source);
            const data = await response.json();
    
            const tb = document.getElementById("tbl");
    
            data.forEach(item => {
                const tr = document.createElement('tr');
    
                ['date', 'netReceivables', 'cashAndCashEquivalents', 'taxAssets', 'otherCurrentLiabilities', 'commonStock', 'totalInvestments'].forEach(key => {
                    const td = document.createElement('td');
                    td.textContent = item[key] || ''; // If the data is not available, set an empty string
                    tr.appendChild(td);
                });
    
                tb.appendChild(tr);
            });
        } catch (error) {
            console.error('Error:', error);
        }
    });
